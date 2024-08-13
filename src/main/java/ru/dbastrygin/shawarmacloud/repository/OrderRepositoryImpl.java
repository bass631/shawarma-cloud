package ru.dbastrygin.shawarmacloud.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dbastrygin.shawarmacloud.model.Ingredient;
import ru.dbastrygin.shawarmacloud.model.Order;
import ru.dbastrygin.shawarmacloud.model.Shawarma;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final JdbcOperations jdbcOperations;

    @Override
    @Transactional
    public Order save(Order order) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Shavarma_order (delivery_name, delivery_street, delivery_city, cc_number, cc_expiration, cc_cvv, placed_at)" +
                        "values (?,?,?,?,?,?,?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);

        order.setPlaceAt(new Date());
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        order.getDeliveryName(),
                        order.getDeliveryStreet(),
                        order.getDeliveryCity(),
                        order.getCcNumber(),
                        order.getCcExpiration(),
                        order.getCcCVV(),
                        order.getPlaceAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        List<Shawarma> shawarmas = order.getShawarmas();
        int i = 0;
        for (Shawarma shawarma : shawarmas) {
            saveShawarma(orderId, i++, shawarma);
        }
        return order;
    }

    private Long saveShawarma(Long orderId, int orderKey, Shawarma shawarma) {
        shawarma.setCreateAt(new Date());

        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Shavarma (name, shawarma_order, shawarma_order_key, create_at) values (?,?,?,?)",
                Types.VARCHAR, Type.LONG, Type.LONG, Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        shawarma.getName(),
                        orderId,
                        orderKey,
                        shawarma.getCreateAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long shawarmaId = keyHolder.getKey().longValue();
        shawarma.setId(shawarmaId);

        saveIngredientRef(shawarmaId, shawarma.getIngredients());

        return shawarmaId;
    }

    private void saveIngredientRef(long shawarmaId, List<Ingredient> ingredients) {
        int key = 0;
        for (Ingredient ingredient : ingredients) {
            jdbcOperations.update("insert into Ingredient_ref (ingredient, shawarma, shawarma_key) values (?,?,?)",
                    ingredient.getId(), shawarmaId, key++);
        }
    }
}


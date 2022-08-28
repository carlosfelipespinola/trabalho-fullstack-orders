package dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.carlosfelipe.pedido.sanduicheria.orders.application.repositories.database_models.OrderDatabaseModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderDatabaseModel, String> {}

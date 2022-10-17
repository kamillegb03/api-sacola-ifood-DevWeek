INSERT INTO RESTAURANTE_MODEL (id, cep, complemento, nome) VALUES
                                                         (1, '0000001', 'Complemento Endereço Restaurante 1', 'Restaurante 1'),
                                                         (2, '0000002', 'Complemento Endereço Restaurante 2', 'Restaurante 2');

INSERT INTO CLIENTE_MODEL (id, cep, complemento, nome) VALUES
    (1, '0000001', 'Complemento Endereço Cliente 1', 'Cliente 1');

INSERT INTO PRODUTO_MODEL (id, disponivel, nome, valor_unitario, restaurante_id) VALUES
                                                                               (1, true, 'Produto 1', 5.0, 1),
                                                                               (2, true, 'Produto 2', 6.0, 1),
                                                                               (3, true, 'Produto 3', 7.0, 2);

INSERT INTO SACOLA_MODEL (id, forma_pagamento, fechada, valor_total, cliente_id) VALUES
    (1, 0, false, 0.0, 1);

INSERT INTO SACOLA_MODEL (id, forma_pagamento, fechada, valor_total, cliente_id) VALUES
    (2, 1, false, 50.0, 1);
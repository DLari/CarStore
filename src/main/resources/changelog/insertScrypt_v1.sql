CREATE TABLE dict_order_status (
                                   id SERIAL  NOT NULL ,
                                   name VARCHAR(20)      ,
                                   PRIMARY KEY(id));




CREATE TABLE users (
                       id SERIAL  NOT NULL ,
                       fio VARCHAR(40)    ,
                       date_of_birth DATE    ,
                       login_client VARCHAR(30)    ,
                       password_client VARCHAR(30)    ,
                       rule  VARCHAR(20)      ,
                       PRIMARY KEY(id));




CREATE TABLE dict_carcass (
                              id SERIAL  NOT NULL ,
                              name VARCHAR(20)      ,
                              PRIMARY KEY(id));




CREATE TABLE color (
                       id SERIAL  NOT NULL ,
                       name VARCHAR(20)    ,
                       price DECIMAL    ,
                       removed BOOL      ,
                       PRIMARY KEY(id));




CREATE TABLE model (
                       id SERIAL  NOT NULL ,
                       dict_carcass_id INTEGER   NOT NULL ,
                       name VARCHAR(20)    ,
                       price DECIMAL    ,
                       width_carcass VARCHAR(20)    ,
                       length_carcass VARCHAR(20)    ,
                       removed BOOL      ,
                       PRIMARY KEY(id)  ,
                       FOREIGN KEY(dict_carcass_id)
                           REFERENCES dict_carcass(id));


CREATE INDEX model_FKIndex1 ON model (dict_carcass_id);


CREATE INDEX IFK_Rel_18 ON model (dict_carcass_id);


CREATE TABLE engine (
                        id SERIAL  NOT NULL ,
                        model_id INTEGER   NOT NULL ,
                        name VARCHAR(20)    ,
                        price DECIMAL    ,
                        removed BOOL    ,
                        fuel_сonsumption INTEGER    ,
                        power INTEGER      ,
                        PRIMARY KEY(id)  ,
                        FOREIGN KEY(model_id)
                            REFERENCES model(id));


CREATE INDEX engine_FKIndex1 ON engine (model_id);


CREATE INDEX IFK_Rel_09 ON engine (model_id);


CREATE TABLE auto_in_stock (
                               id SERIAL  NOT NULL ,
                               color_id INTEGER   NOT NULL ,
                               engine_id INTEGER   NOT NULL ,
                               model_id INTEGER   NOT NULL ,
                               presence INTEGER      ,
                               PRIMARY KEY(id)      ,
                               FOREIGN KEY(model_id)
                                   REFERENCES model(id),
                               FOREIGN KEY(engine_id)
                                   REFERENCES engine(id),
                               FOREIGN KEY(color_id)
                                   REFERENCES color(id));


CREATE INDEX auto_in_stock_FKIndex1 ON auto_in_stock (model_id);
CREATE INDEX auto_in_stock_FKIndex2 ON auto_in_stock (engine_id);
CREATE INDEX auto_in_stock_FKIndex3 ON auto_in_stock (color_id);


CREATE INDEX IFK_Rel_20 ON auto_in_stock (model_id);
CREATE INDEX IFK_Rel_21 ON auto_in_stock (engine_id);
CREATE INDEX IFK_Rel_22 ON auto_in_stock (color_id);


CREATE TABLE orders (
                        id SERIAL  NOT NULL ,
                        auto_in_stock_id INTEGER   NOT NULL ,
                        dict_order_status_id INTEGER   NOT NULL ,
                        users_id INTEGER   NOT NULL ,
                        date DATE    ,
                        price DECIMAL      ,
                        PRIMARY KEY(id)      ,
                        FOREIGN KEY(users_id)
                            REFERENCES users(id),
                        FOREIGN KEY(dict_order_status_id)
                            REFERENCES dict_order_status(id),
                        FOREIGN KEY(auto_in_stock_id)
                            REFERENCES auto_in_stock(id));


CREATE INDEX orders_FKIndex1 ON orders (users_id);
CREATE INDEX orders_FKIndex2 ON orders (dict_order_status_id);
CREATE INDEX orders_FKIndex3 ON orders (auto_in_stock_id);


CREATE INDEX IFK_Rel_23 ON orders (users_id);
CREATE INDEX IFK_Rel_24 ON orders (dict_order_status_id);
CREATE INDEX IFK_Rel_25 ON orders (auto_in_stock_id);




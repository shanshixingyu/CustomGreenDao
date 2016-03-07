package com.example;

import com.shanshixingyu.daogenerator.CustomGreenDaoGenerator;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class CustomGreenDaoGeneratorExample {
    public static void main(String[] args)
        throws Exception {

        Schema schema = new Schema(1, "com.meitu.mtgreendaodemo.db.bean");

        Entity noteEntity = schema.addEntity("Note");
        noteEntity.addLongProperty("id").primaryKey();
        noteEntity.addStringProperty("name").notNull();
        noteEntity.addStringProperty("author").notNull();
        noteEntity.addLongProperty("time");

        Entity userEntity = schema.addEntity("User");
        userEntity.addLongProperty("id").primaryKey();
        userEntity.addStringProperty("name").notNull();
        userEntity.addIntProperty("age");

        // new DaoGenerator().generateAll(schema, "app/src/main/java");
        new CustomGreenDaoGenerator().generateAll(schema, "app/src/main/java");
    }
}

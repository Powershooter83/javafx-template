module me.prouge.mazebank {
    requires javafx.controls;
    requires me.prouge.guicefx;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires org.apache.logging.log4j;

    opens me.prouge.template;
    opens me.prouge.template.entities;
    opens me.prouge.template.controllers;
    opens me.prouge.template.controllers.cells;
    opens me.prouge.template.utils;
    opens me.prouge.template.factories;
    opens me.prouge.template.services;

    exports me.prouge.template;
}

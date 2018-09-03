package com.zakharchenko.oksana.getplaces.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.zakharchenko.oksana.getplaces.db.dao.BillDao;
import com.zakharchenko.oksana.getplaces.db.dao.PlaceDao;
import com.zakharchenko.oksana.getplaces.db.dao.PlaceGroupDao;
import com.zakharchenko.oksana.getplaces.db.dao.PlaceGroupSchemaDao;
import com.zakharchenko.oksana.getplaces.db.dao.PlaceUnionDao;
import com.zakharchenko.oksana.getplaces.db.model.Bill;
import com.zakharchenko.oksana.getplaces.db.model.Place;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroup;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroupSchema;
import com.zakharchenko.oksana.getplaces.db.model.PlaceUnion;

@Database(entities = { Bill.class, Place.class, PlaceGroup.class, PlaceGroupSchema.class, PlaceUnion.class},
        version = 1)
public abstract class AppDatabase extends RoomDatabase {

        public abstract BillDao getBillDao();
        public abstract PlaceDao getPlaceDao();
        public abstract PlaceGroupDao getPlaceGroupDao();
        public abstract PlaceGroupSchemaDao getPlaceGroupSchemaDao();
        public abstract PlaceUnionDao getPlaceUnionDao();

}

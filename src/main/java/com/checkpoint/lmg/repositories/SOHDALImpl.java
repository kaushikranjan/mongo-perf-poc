package com.checkpoint.lmg.repositories;

import com.checkpoint.lmg.models.SOHKey;
import com.checkpoint.lmg.models.SOHModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SOHDALImpl implements SOHDAL {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public SOHDALImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void insert(SOHModel model) {
        mongoTemplate.save(model);
    }

    @Override
    @Async("threadPoolTaskExecutor")
    public void bulk (List<SOHModel> models) {
        BulkOperations bulks = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, SOHModel.class);
        for(SOHModel model: models) {
            Query query = generateQuery(model);
            Update update = generateUpdate(model);
            bulks.upsert(query, update);
        }
        bulks.execute();
    }

    public Update generateUpdate(SOHModel model) {
        Update update = new Update();
        update.set("qty", model.getQty());
        update.set("price", model.getPrice());
        update.set("key", model.getKey());
        return update;
    }

    public Query generateQuery(SOHModel model) {
        SOHKey key = model.getKey();
        Query query = new Query();
        query.addCriteria(Criteria.where("key").is(key));
        return query;
    }
}

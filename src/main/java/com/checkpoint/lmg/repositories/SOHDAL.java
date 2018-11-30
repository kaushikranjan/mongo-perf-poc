package com.checkpoint.lmg.repositories;

import com.checkpoint.lmg.models.SOHModel;
import java.util.List;

public interface SOHDAL {
    void insert (SOHModel model);
    void bulk (List<SOHModel> models);
}
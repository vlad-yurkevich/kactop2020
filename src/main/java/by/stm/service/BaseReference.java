package by.stm.service;

import java.util.List;

public interface BaseReference {
    String getValue(int idRef, int idValue);
    List getList(int idRef);
    List getListByParentId(int idRef, int idParent);
    void doRefresh(int idRef);
}

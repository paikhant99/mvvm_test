
package com.paikhantko.mvvm_test.models.entities;

import java.util.List;

@lombok.Data
@SuppressWarnings("unused")
public class Data {

    private String lastUpdate;
    private PaginationMeta paginationMeta;
    private List<Row> rows;

}

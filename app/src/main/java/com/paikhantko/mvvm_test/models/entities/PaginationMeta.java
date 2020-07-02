
package com.paikhantko.mvvm_test.models.entities;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class PaginationMeta {

    private long currentPage;
    private long currentPageSize;
    private long totalPages;
    private long totalRecords;

}

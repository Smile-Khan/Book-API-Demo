package com.example.bookapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagedResponse<T> {
    private List<T> content;
    private int page;            // renamed from pageNumber
    private int size;            // renamed from pageSize
    private long totalElements;
    private int totalPages;
    private boolean last;
}

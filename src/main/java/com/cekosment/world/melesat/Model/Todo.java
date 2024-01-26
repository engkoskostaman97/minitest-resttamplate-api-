package com.cekosment.world.melesat.Model;

import lombok.Data;

@Data
public class Todo {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;
}


package com.ocelot.xssf;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
public class SheetEntity {

    public SheetEntity(String sheetName, String rId) {
        this.sheetName = sheetName;
        this.rId = rId;
    }

    private String sheetName;   // workbook - sheets - sheet - name
    private String rId;         // workbook - sheets - sheet - r:id
}

package com.chanchal.optionstradeservice.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

///home/hp/dev/work/FinancialData/option_trades/option_stock_dump_file.csv
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
public class OptionsTradesTO {

    private long id;
    private String oi;
    private String oiChange;
    private String volume;
    private String chgInLtp;
    private String ltp;
    private String strikePrice;
    private String ltp1;
    private String chgInLtp1;
    private String volume1;
    private String oiChange1;
    private String oi1;
    private String symbol;
    private String mcSymbol;
    private String undrlngSt;
    private String expiry;
    private String extractionDt;

}

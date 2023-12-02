package com.chanchal.optionstradeservice.bo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

///home/hp/dev/work/FinancialData/option_trades/option_stock_dump_file.csv
@Entity
@Table(name = "tbl_option_trades", schema = "futures")
@Getter
@Setter
@ToString
public class OptionsTradesBO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private Long orderId;
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
    private String brokerClient;
    @CreationTimestamp
    private Timestamp createdDt;
    @CreationTimestamp
    private Timestamp modifiedDt;

}

package com.example.demomobilv4.Entity;

public class ResultsDB {

    private String codigoResult;
    private String valorResult;
    private String descripcionResult;

    public ResultsDB(String codigoResult, String valorResult, String descripcionResult) {
        this.codigoResult = codigoResult;
        this.valorResult = valorResult;
        this.descripcionResult = descripcionResult;
    }

    public ResultsDB(){

    }

    public String getCodigoResult() {
        return codigoResult;
    }

    public void setCodigoResult(String codigoResult) {
        this.codigoResult = codigoResult;
    }

    public String getValorResult() {
        return valorResult;
    }

    public void setValorResult(String valorResult) {
        this.valorResult = valorResult;
    }

    public String getDescripcionResult() {
        return descripcionResult;
    }

    public void setDescripcionResult(String descripcionResult) {
        this.descripcionResult = descripcionResult;
    }
}

package com.paikhantko.mvvm_test.models.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "text_table")
public class Text {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "sentence")
    private String sentence;

    public Text(String sentence) {
        this.sentence = sentence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}

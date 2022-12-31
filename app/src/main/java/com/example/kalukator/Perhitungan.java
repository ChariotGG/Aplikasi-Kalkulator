package com.example.kalukator;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Perhitungan {
    public double angka1;
    public double angka2;
    public int check;

    public Perhitungan(double angka1, double angka2, int check){
        this.angka1 = angka1;
        this.angka2 = angka2;
        this.check = check;
    }

    @Override
    public String toString() {
        if(check == 1){
            return angka1 + " + " + angka2;
        }
        else if(check == 2){
            return angka1 + " - " + angka2;
        }
        else if(check == 3){
            return angka1 + " * " + angka2;
        }
        else if(check == 4){
            return angka1 + " / " + angka2;
        }
        else {
            return "0";
        }
    }

    public String getHasil() {
        if(check == 1){
            return "= " + Double.toString((angka1 + angka2));
        }
        else if(check == 2){
            return "= " + Double.toString((angka1 - angka2));
        }
        else if(check == 3){
            return "= " + Double.toString((angka1 * angka2));
        }
        else if(check == 4){
            return "= " + Double.toString((angka1 / angka2));
        }
        else {
            return Double.toString(0);
        }
    }
}

package model;

import java.util.ArrayList;

public class Makingproblem {

	public ArrayList<Integer> execute(){

	ArrayList<Integer> problemnumber = new ArrayList<Integer>();
    int r = new java.util.Random().nextInt(20);
    problemnumber.add(r);

    for(int shiraberu=1;shiraberu<20; shiraberu++){
        int tamesu=0;
        int c = new java.util.Random().nextInt(20);
        do{
            if(c != problemnumber.get(tamesu)){
                tamesu++;
            }else{
                shiraberu -= 1;
                break;

            }
            if(tamesu==shiraberu){
                problemnumber.add(c); ;
            }}while(tamesu < shiraberu);
    }
    return problemnumber;





    }

}

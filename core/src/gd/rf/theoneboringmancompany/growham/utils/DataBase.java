package gd.rf.theoneboringmancompany.growham.utils;

public class DataBase {
    public String playerScore(int i){
        String result = "-";
        switch (i){
            case 1:
                result = " 1";
                break;
            case 2:
                result = " 2";
                break;
            case 3:
                result = " 3";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }
}

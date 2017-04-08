package demo.testlu.lumyapplication.Bean;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class Item {
    private int img;
    private String text;

    public Item(int img, String text) {
        this.img = img;
        this.text = text;

    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;


    }

    public void setText(String text) {
        this.text = text;
    }
}

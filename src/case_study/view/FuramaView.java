package case_study.view;

import case_study.controller.FurammaController;

import java.io.IOException;

public class FuramaView {
    public static void main(String[] args) throws IOException {
        FurammaController furama = new FurammaController();
        furama.menuUser();
    }
}

package ss16_text_file.exercise.copy_file_text.controller;

import ss16_text_file.exercise.copy_file_text.model.CopyFileText;


import java.util.List;

public class CopyFileTextController {
    public static void main(String[] args) {
        List<String> strings = CopyFileText.readFile("src/ss16_text_file/exercise/copy_file_text/model/sourcefile.txt");
        CopyFileText.writeFile("src/ss16_text_file/exercise/copy_file_text/model/targetfile.txt", strings);
    }
}

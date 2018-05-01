/*
 * Harris Dizdarevic
 * CISC. 3150
 * Homework 8
 *
 * Write a Program that outputs a tree directory diagram into dir_tree.txt
 *
 * Can start from any folder, not the entire root directory since it will be
 * huge
 *
 * Use the File Class Java 8
 * Link: https://docs.oracle.com/javase/8/docs/api/java/io/File.html
 *
 * Methods that seem to be useful:
 *  listFiles()
 *  isDirectory()
 *  isFile()
 *  getName()
 *
 *  Algorithm:
 *      Start at the top level directory
 *      Get the list of files in that directory
 *      Iterate through files in the curr directory
 *          if a File object is a directory then
 *              Print the directory name with an indent
 *              recursively do the same until you reach the end (i.e. no directories found at the lowest level) with indent further extended
 *          else if it's a file {
 *              Print the file name with an indent according to the level
 *              directory (maybe keep an account on how many levels in I get to
 *              determine indentation?)
 *          }
 *
 */

import java.io.File;

public class FileTree {
    public static void main(String[] args) {
        File startingDirectory = new File("TestDirectory");
        outputDirectoryTree(startingDirectory, 0);
    }

    public static void outputDirectoryTree(File startingDirectory, int level) {
        File[] directoryContents = startingDirectory.listFiles();
        String currFile = "|";

        for(int i = 0; i < level; i++) {
            currFile += "-";
        }
        currFile += startingDirectory.getName() + "/"; //Illustrate that it's a directory
        System.out.println(currFile);
        currFile = "|"; //reset the String for if it is a file later on

        for(File file : directoryContents) {
            if(file.isDirectory()) {
                outputDirectoryTree(file, level + 1);
            }
            if(file.isFile()) {
                for(int i = 0; i < level + 1; i++) {
                    currFile += "-";
                }
                currFile += file.getName();
                System.out.println(currFile);
            }
        }
    }
}

package selenium;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Login_Script {
    public static ActionKeyWords actionKeyWords;
    public static String Keywords = null;
    public static Method[] method;

    public Login_Script() {
        actionKeyWords = new ActionKeyWords();
        method = actionKeyWords.getClass().getMethods();
    }

    public static void main(String[] agrs) throws Exception {
        ExcelUtils.setExcelFile();
        new Login_Script();
        for (int RowNum = 1; RowNum <= ExcelUtils.getLastRowNums(); RowNum++) {
            ExcelUtils.getCellDate();
            login_action();
        }
    }

    public static void login_action() {
        for (int i = 0; i < method.length; i++) {
//                    System.out.println(method[i].getName()+"     "+actionKeyWords+Keywords);
            if (method[i].getName().trim().equals(Keywords)) {
                try {
                    method[i].invoke(actionKeyWords);
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

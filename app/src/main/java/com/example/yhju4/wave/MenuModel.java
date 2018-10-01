package com.example.yhju4.wave;



import java.util.Comparator;

public class MenuModel {
    public String menuName;
    public boolean hasChildren, isGroup;

    public MenuModel(String menuName, boolean isGroup, boolean hasChildren) {
        this.menuName = menuName;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }

    public static Comparator<MenuModel> menuModelComparator = new Comparator<MenuModel>() {
        @Override
        public int compare(MenuModel o1, MenuModel o2) {
            String menuName1 = o1.getMenuName();
            String menuName2 = o2.getMenuName();

            return menuName1.compareTo(menuName2);
        }

    };

    public String getMenuName() {
        return menuName;
    }


}

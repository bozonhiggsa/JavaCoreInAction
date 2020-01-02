package net.core.tutorial.medium._03_I18nL10n;

import java.util.Locale;
import java.util.Scanner;

/**

 Интернационализация – написание приложения так, чтобы перевод его на другую локаль не был проблематичным.
 Это означает отказ от использования непосредственно в коде сообщений, форматов и т.п. – всего, что может
 зависеть от языка и других особенностей региона.

 Локаль – географический регион. Локаль представлена в виде объекта java.util.Locale.
 Локаль характеризуется:
 1. Языком;
 2. Страной;
 3. Вариантом языка.
 Локаль используется для идентификации языка.
 Для получения дефолтной системной локали можно использовать метод Locale.getDefault().
 Для создания объекта локали можно использовать конструктор, в котором задать в виде строк или только язык,
 или язык и страну, или язык, страну и вариант. Вне зависимости от регистра букв на входе, на выходе получим
 язык в нижнем регистре, страну в верхнем регистре, вариант как есть, разделённые знаком подчёркивания.

 Базовые локали следующие:
 en_US
 en_GB
 en_CA
 en_CA
 fr_FR
 fr_CA
 de_DE
 it_IT
 ru_RU
 ua_UA

 Локализация – создание набора ресурсов для перевода приложения на другой язык.

 */

public class _01_I18nL10n_1 {

    public static void main(String[] args) {

        System.out.println(Locale.getDefault());

        Locale locale = new Locale("LANGuage", "COUntry", "VARiaNt");
        System.out.println(locale);

        System.out.println("------------------");

        locale = new Locale("fr", "FR");
        System.out.println(locale);
        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());

        Scanner scanner1 = new Scanner("34,34  43,43");
        scanner1.useLocale(locale);
        System.out.println(scanner1.nextDouble());
        System.out.println(scanner1.nextDouble());

        System.out.println("------------------");

        locale = new Locale("ua", "UA");
        System.out.println(locale);

        Scanner scanner2 = new Scanner("34.34  43.43");
        scanner2.useLocale(locale);
        System.out.println(scanner2.nextDouble());
        System.out.println(scanner2.nextDouble());
    }
}

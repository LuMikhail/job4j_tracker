package ru.job4j.lamda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Класс сравнивает объекты и сортирует их с помощью ананимного класса:
 * <p>
 * 1. по размеру.
 * <p>
 * 2. по имени.
 *
 * @version 1.0
 */
public class AttachmentSort {

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );

        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> sortName = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(sortName);
        System.out.println(attachments);
    }
}

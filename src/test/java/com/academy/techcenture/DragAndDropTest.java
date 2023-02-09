package com.academy.techcenture;

import com.academy.techcenture.pages.DragAndDrop;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest{

    @Test
    public void DragAndDropTestCase(){
        DragAndDrop dragAndDrop = new DragAndDrop(driver,softAssert);
        dragAndDrop.dragAndDropAction();

    }
}

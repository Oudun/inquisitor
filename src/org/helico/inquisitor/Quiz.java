package org.helico.inquisitor;

import org.helico.inquisitor.impl.DaoImpl;
import org.helico.inquisitor.model.ItemPropertyValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 14.12.13
 * Time: 4:03
 * To change this template use File | Settings | File Templates.
 */
public class Quiz {

    public List<ItemPropertyValue> getQuestions(int number, String themeId) {
        List<ItemPropertyValue> result = new ArrayList<ItemPropertyValue>();
        Dao dao = new DaoImpl();
        List<ItemPropertyValue> correct = dao.getCorrectAnswers(themeId);
        List<ItemPropertyValue> wrong = dao.getAllAnswers(themeId);
        wrong.removeAll(correct);
        Random random = new Random();
        int numCorrect = random.nextInt(number + 1);
        for (int i=0; i<numCorrect; i++) {
            int randomPosition = random.nextInt(correct.size());
            ItemPropertyValue itemPropertyValue = correct.get(randomPosition);
            result.add(itemPropertyValue);
            correct.remove(randomPosition);
        }
        for (int i=0; i<number-numCorrect; i++) {
            int randomPosition = random.nextInt(wrong.size());
            ItemPropertyValue itemPropertyValue = wrong.get(randomPosition);
            result.add(itemPropertyValue);
            wrong.remove(randomPosition);
        }
        shuffleList(result);
        return result;
    }

     private void shuffleList(List<ItemPropertyValue> list) {
        int n = list.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(list, i, change);
        }
     }

    private void swap(List<ItemPropertyValue> list, int i, int change) {
        ItemPropertyValue helper = list.get(i);
        list.set(i, list.get(change));
        list.set(change, helper);
    }

}


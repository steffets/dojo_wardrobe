package de.dojo.wardrobe.service;

import de.dojo.wardrobe.model.Combination;
import de.dojo.wardrobe.model.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WardrobeService {

    public List<Combination> getWardrobeCombinations(List<Element> elements, int size) {
        List<Combination> result = new ArrayList<>();
        if (elements.size() == 1) {
            if (elements.getFirst().getSize() == size) {
                result.add(new Combination(List.of(elements.getFirst())));
            }
        }
        for(int i = 0; i < elements.size(); i++) {
            for(int j = 0; j < elements.size(); j++) {
                if(i==j) {
                    continue;
                }
                int currentSize = elements.get(i).getSize() + elements.get(j).getSize();
                if (currentSize == size) {
                    result.add(new Combination(List.of(elements.get(i), elements.get(j))));
                }
            }
        }
        return result;
    }

}

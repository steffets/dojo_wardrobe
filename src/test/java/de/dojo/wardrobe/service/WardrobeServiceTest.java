package de.dojo.wardrobe.service;

import de.dojo.wardrobe.model.Combination;
import de.dojo.wardrobe.model.Element;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WardrobeServiceTest {

    private WardrobeService service = new WardrobeService();

    @Test
    void ElementFit() {
        // given
        Element element = new Element(1, 250);
        List<Element> elements = List.of(element);
        // when
        List<Combination> result = service.getWardrobeCombinations(elements, 250);
        // then
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result.getFirst().getElements().size()).isEqualTo(1);
        Assertions.assertThat(result.getFirst().getElements().getFirst().getId()).isEqualTo(1);
    }

    @Test
    void ElementsDontFit() {
        // given
        Element element = new Element(1, 260);
        List<Element> elements = List.of(element);
        // when
        List<Combination> result = service.getWardrobeCombinations(elements, 250);
        // then
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    void Combine3Elements() {
        // given
        Element element1 = new Element(1, 100);
        Element element2 = new Element(2, 150);
        Element element3 = new Element(3, 50);
        List<Element> elements = List.of(element1, element2, element3);
        // when
        List<Combination> result = service.getWardrobeCombinations(elements, 250);
        // then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result)
                .satisfiesExactlyInAnyOrder(
                        combination -> Assertions.assertThat(combination.getElements()).containsExactlyInAnyOrder(element2,element1),
                        combination -> Assertions.assertThat(combination.getElements()).containsExactlyInAnyOrder(element1,element2)
                );

    }


}
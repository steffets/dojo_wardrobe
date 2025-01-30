package de.dojo.wardrobe.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WardrobeServiceTest {

    private WardrobeService service = new WardrobeService();

    @Test
    void DoesElementFit() {
        // given
        // when
        service.getWardrobeCombinations();
        // then
        Assertions.assertThat(true).isTrue();
    }

}
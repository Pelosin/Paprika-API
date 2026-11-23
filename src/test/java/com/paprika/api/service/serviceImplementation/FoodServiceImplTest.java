package com.paprika.api.service.serviceImplementation;

import com.paprika.api.domain.Food;
import com.paprika.api.mapper.FoodMapper;
import com.paprika.api.payload.response.FoodResponse;
import com.paprika.api.repo.FoodRepo;
import com.paprika.api.service.FoodService;
import com.paprika.api.util.FoodCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class FoodServiceImplTest {
    @InjectMocks
    private FoodServiceImpl foodService;

    @Mock
    private FoodRepo foodRepoMock;

    @Spy
    private FoodMapper foodMapper = new FoodMapper(null);

    @BeforeEach
    void setUp(){


        BDDMockito.when(foodRepoMock.findAll())
                .thenReturn(List.of(FoodCreator.createValidFood()));

        BDDMockito.when(foodRepoMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(FoodCreator.createValidFood()));

        BDDMockito.when(foodRepoMock.save(ArgumentMatchers.any(Food.class)))
                .thenReturn(FoodCreator.createValidFood());

        BDDMockito.doNothing().when(foodRepoMock).delete(ArgumentMatchers.any(Food.class));
    }


    @Test
    @DisplayName("findAll returns a List of FoodResponse when successful")
    void findAll_ReturnsListOfFood_WhenSuccessful(){
        String expectedName = FoodCreator.createValidFood().getName();

        List<FoodResponse> foodList = foodService.getAllFood();

        Assertions.assertThat(foodList).isNotNull().hasSize(1);
        Assertions.assertThat(foodList.get(0).getName()).isEqualTo(expectedName);

    }

}
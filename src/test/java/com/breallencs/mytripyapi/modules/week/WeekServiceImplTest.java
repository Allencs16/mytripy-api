package com.breallencs.mytripyapi.modules.week;

import com.breallencs.mytripyapi.modules.budget.Budget;
import com.breallencs.mytripyapi.modules.expenses.Expenses;
import com.breallencs.mytripyapi.modules.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class WeekServiceImplTest {

    @Mock
    private WeekRepository weekRepository;

    @InjectMocks
    private WeekServiceImpl weekService;

    @Captor
    private ArgumentCaptor<Week> weekCaptor;

    @Mock
    private List<Expenses> expenses;

    @Mock
    private List<Budget> budgets;

    @Mock
    private User user;

    @Test
    @DisplayName("Should disable week")
    void DisableWeektest() {
        // Arrange
        Long id = 1L;
        Double totalPrice = 100.0;
        Double totalKm = 500.0;
        Double totalBudget = 200.0;
        Double totalExpenses = 150.0;
        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 8, 7);
        String userName = "John Doe";
        boolean isCurrent = true;

        // Create the existing Week object
        Week existingWeek = new Week(id, totalPrice, totalKm, totalBudget, totalExpenses, startDate, endDate, isCurrent, user, expenses, budgets);

        given(weekRepository.findById(id)).willReturn(Optional.of(existingWeek));

        // Act
        ResponseEntity<?> responseEntity = weekService.disableWeek(id);

        // Assert
        // Capture the Week object passed to saveAndFlush
        then(weekRepository).should().save(weekCaptor.capture());
        Week savedWeek = weekCaptor.getValue();

        // Assert that the status code is OK
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Assert that the isCurrent field is now false
        Assertions.assertFalse(savedWeek.isCurrent());

        // Assert that the response body is the savedWeek and that it is also not current
        Assertions.assertFalse(((Week) responseEntity.getBody()).isCurrent());
    }
}

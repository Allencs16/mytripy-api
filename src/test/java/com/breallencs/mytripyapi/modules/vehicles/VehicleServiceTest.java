package com.breallencs.mytripyapi.modules.vehicles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

  @InjectMocks
  private VehicleServiceImpl vehicleServiceImpl;

  @Mock
  private VehicleRepository vehicleRepository;

  @Mock
  private Vehicles vehiclesExpected;

  @Captor
  private ArgumentCaptor<Vehicles> vehicleCaptor;

  @Test
  @DisplayName("Verifica se o veiculo é criado")
  void CreateVehicleTest() {
    // Arrange
    VehicleDTO vehicleDTO = new VehicleDTO(1L, "teste", 25.0, "teste", 12.0, 12.0);

    // Act
    vehicleServiceImpl.createNewVehicle(vehicleDTO);

    // Assert
    then(vehicleRepository).should().saveAndFlush(vehicleCaptor.capture());
    Vehicles savedVehicle = vehicleCaptor.getValue();

    // Skip ID assertion and focus on other fields
    Assertions.assertEquals(vehicleDTO.getName(), savedVehicle.getName());
    Assertions.assertEquals(vehicleDTO.getPrice(), savedVehicle.getPrice());
    Assertions.assertEquals(vehicleDTO.getBrand(), savedVehicle.getBrand());
    Assertions.assertEquals(vehicleDTO.getKmAveragePerLiter(), savedVehicle.getKmAveragePerLiter());
    Assertions.assertEquals(vehicleDTO.getMaxDistance(), savedVehicle.getMaxDistance());
  }

  @Test
  @DisplayName("Verifica se o veiculo é editado corretamente")
  void EditVehicleTest() {
    // Arrange
    Long vehicleId = 1L;
    VehicleDTO vehicleDTO = new VehicleDTO(vehicleId, "novoTeste", 30.0, "novaMarca", 15.0, 20.0);
    Vehicles existingVehicle = new Vehicles(vehicleId, "teste", 25.0, "marca", 12.0, 12.0);

    given(vehicleRepository.findById(vehicleId)).willReturn(Optional.of(existingVehicle));

    // Act
    Vehicles updatedVehicle = vehicleServiceImpl.editVehicle(vehicleId, vehicleDTO);

    // Assert
    then(vehicleRepository).should().saveAndFlush(vehicleCaptor.capture());
    Vehicles savedVehicle = vehicleCaptor.getValue();

    // Check if the returned vehicle matches the updated data
    Assertions.assertEquals(vehicleDTO.getName(), savedVehicle.getName());
    Assertions.assertEquals(vehicleDTO.getPrice(), savedVehicle.getPrice());
    Assertions.assertEquals(vehicleDTO.getBrand(), savedVehicle.getBrand());
    Assertions.assertEquals(vehicleDTO.getKmAveragePerLiter(), savedVehicle.getKmAveragePerLiter());
    Assertions.assertEquals(vehicleDTO.getMaxDistance(), savedVehicle.getMaxDistance());

    // Check that the method returns the updated vehicle correctly
    Assertions.assertEquals(savedVehicle, updatedVehicle);
  }

}

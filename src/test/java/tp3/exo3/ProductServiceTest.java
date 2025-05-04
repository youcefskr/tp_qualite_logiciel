package tp3.exo3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Test
    public void testGetProduct_Success() throws ApiException {
        // Arrange
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClientMock);
        String productId = "123";
        Product expectedProduct = new Product(productId, "Test Product");
        when(apiClientMock.getProduct(productId)).thenReturn(expectedProduct);

        // Act
        Product result = productService.getProduct(productId);

        // Assert
        assertEquals(expectedProduct, result);
        verify(apiClientMock).getProduct(productId);
    }

    @Test
    public void testGetProduct_ApiFailure() throws ApiException {
        // Arrange
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClientMock);
        String productId = "123";
        ApiException expectedException = new ApiException("API Error");
        when(apiClientMock.getProduct(productId)).thenThrow(expectedException);

        // Act & Assert
        assertThrows(ApiException.class, () -> productService.getProduct(productId));
        verify(apiClientMock).getProduct(productId);
    }

    @Test
    public void testGetProduct_NullProduct() throws ApiException {
        // Arrange
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClientMock);
        String productId = "123";
        when(apiClientMock.getProduct(productId)).thenReturn(null);

        // Act
        Product result = productService.getProduct(productId);

        // Assert
        assertNull(result);
        verify(apiClientMock).getProduct(productId);
    }
}
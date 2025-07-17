package work.maet.clients.mapper;

import work.maet.clients.models.Address;
import work.maet.clients.response.AddressResponse;

public class AddressMapper {

    public static AddressResponse toResponse(Address address) {
        return new AddressResponse(
                address.getId(),
                address.getLine1(),
                address.getLine2(),
                address.getCity(),
                address.getProvince(),
                address.getPostalCode(),
                address.getCountry()
        );
    }
}

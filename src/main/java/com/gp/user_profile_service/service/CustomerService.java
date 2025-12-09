package com.gp.user_profile_service.service;


import com.gp.user_profile_service.entity.Customer;
import com.gp.user_profile_service.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepository;



   public Customer saveCustomer(Customer customer){
        if(customerRepository.findByEmail(customer.getEmail())!=null){
            throw new RuntimeException("Customer with email "+customer.getEmail()+" already exists");
        }

        Customer customerToSave = Customer.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .mobile(customer.getMobile())
                .status(customer.getStatus())
                .build();
        customerToSave.setPassword(customer.getPassword()); // set password separately
       return customerRepository.save(customer);
   }


   public Customer getCustomerById(Long id){
       return customerRepository.findById(id)
               .orElseThrow(()->new RuntimeException("Customer with id "+id+" not found"));
   }


//    public void handleOrderCreated(OrderCreatedEvent event) {
//
//        Customer customer = customerRepository.findById(event.getCustomerId())
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//
////        customer.setPr(event.getTotalPrice());
////        customer.setLastOrderItems(event.getItems().toString());
//        customerRepository.save(customer);
//
//        System.out.println("Customer updated successfully for order=" + event.getOrderId());
//    }
}

package case_study.model.customer;

import case_study.model.person.Person;

public class Customer extends Person {
    private String customerId;
    private String customerType;
    private String addressCustomer;

    public Customer(String customerId, String customerType, String addressCustomer) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.addressCustomer = addressCustomer;
    }

    public Customer(String nameEmployee, String dayOfBirth, String gender, String idCard, String numberOfPhone, String email, String customerId, String customerType, String addressCustomer) {
        super(nameEmployee, dayOfBirth, gender, idCard, numberOfPhone, email);
        this.customerId = customerId;
        this.customerType = customerType;
        this.addressCustomer = addressCustomer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", super.toString(), customerId, customerType, addressCustomer);
//        return "Customer{" +
//                "customerId='" + customerId + '\'' +
//                ", customerType='" + customerType + '\'' +
//                ", addressCustomer='" + addressCustomer + '\'' +
//                '}';
    }
}

package com.webservice.EcWebService.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

/**
 * Company customer
 *
 * @author Emmanuel Bernard
 */
@Entity
public class Customer implements java.io.Serializable
{
   Long id;
   String name;
   Set<Flight> flights;
   Address address;

   public Customer()
   {
   }

   @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
   public Long getId()
   {
      return id;
   }

   public String getName()
   {
      return name;
   }

   public void setId(Long long1)
   {
      id = long1;
   }

   public void setName(String string)
   {
      name = string;
   }

   @OneToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name = "ADDRESS_ID")
   public Address getAddress()
   {
      return address;
   }

   public void setAddress(Address address)
   {
      this.address = address;
   }

   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, mappedBy="customers")
   public Set<Flight> getFlights()
   {
      return flights;
   }

   public void setFlights(Set<Flight> flights)
   {
      this.flights = flights;
   }


}

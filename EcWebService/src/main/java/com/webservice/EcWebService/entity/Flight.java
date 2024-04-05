package com.webservice.EcWebService.entity;

/*
* JBoss, Home of Professional Open Source
* Copyright 2005, JBoss Inc., and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
//$Id: Flight.java,v 1.4.2.10 2006/03/21 00:00:32 bill Exp $

import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

/**
 * Flight
 *
 * @author Emmanuel Bernard
 */
@Entity()
public class Flight implements java.io.Serializable
{
   Long id;
   String name;
   long duration;
   long durationInSec;
   Integer version;
   Set<Customer> customers;

   @Id
   public Long getId()
   {
      return id;
   }

   public void setId(Long long1)
   {
      id = long1;
   }

   @Column(updatable = false, name = "flight_name", nullable = false, length = 50)
   public String getName()
   {
      return name;
   }

   public void setName(String string)
   {
      name = string;
   }

   @Basic(fetch = FetchType.LAZY)
   public long getDuration()
   {
      return duration;
   }

   public void setDuration(long l)
   {
      duration = l;
      //durationInSec = duration / 1000;
   }

   @Transient
   public long getDurationInSec()
   {
      return durationInSec;
   }

   public void setDurationInSec(long l)
   {
      durationInSec = l;
   }

   @Version
   @Column(name = "OPTLOCK")
   public Integer getVersion()
   {
      return version;
   }

   public void setVersion(Integer i)
   {
      version = i;
   }

   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
   @JoinTable(name = "flight_customer_table",
                     joinColumns = {@JoinColumn(name = "FLIGHT_ID")},
                     inverseJoinColumns = {@JoinColumn(name = "CUSTOMER_ID")})
   public Set<Customer> getCustomers()
   {
      return customers;
   }

   public void setCustomers(Set<Customer> customers)
   {
      this.customers = customers;
   }
}
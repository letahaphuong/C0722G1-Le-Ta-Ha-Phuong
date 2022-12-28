import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ReactiveFormsModule} from '@angular/forms';
import { ContractListComponent } from './contract/contract-list/contract-list.component';
import { ContractCreateComponent } from './contract/contract-create/contract-create.component';
import { ContractEditComponent } from './contract/contract-edit/contract-edit.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { FacilityEditComponent } from './faiclity/facility-edit/facility-edit.component';
import { FacilityListComponent } from './faiclity/facility-list/facility-list.component';
import { FacilityCreateComponent } from './faiclity/facility-create/facility-create.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './employee/employee-create/employee-create.component';
import { EmployeeEditComponent } from './employee/employee-edit/employee-edit.component';
import {HeaderComponent} from './header/header.component';
import {NavComponent} from './nav/nav.component';
import {FooterComponent} from './footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    ContractListComponent,
    ContractCreateComponent,
    ContractEditComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerEditComponent,
    FacilityEditComponent,
    FacilityListComponent,
    FacilityCreateComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent,
    HeaderComponent,
    NavComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

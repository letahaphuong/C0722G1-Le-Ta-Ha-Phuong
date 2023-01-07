import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentListComponent } from './component/component-list/component-list.component';
import { ComponentCreateComponent } from './component/component-create/component-create.component';
import { ComponentDeleteComponent } from './component/component-delete/component-delete.component';
import { ComponentDetailComponent } from './component/component-detail/component-detail.component';
import { ComponentEditComponent } from './component/component-edit/component-edit.component';
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToastrModule} from "ngx-toastr";
import {NgxPaginationModule} from "ngx-pagination";
import {ReactiveFormsModule} from "@angular/forms";
import { ComponentCreateSanPhamComponent } from './component/component-create-san-pham/component-create-san-pham.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentListComponent,
    ComponentCreateComponent,
    ComponentDeleteComponent,
    ComponentDetailComponent,
    ComponentEditComponent,
    ComponentCreateSanPhamComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(),
    NgxPaginationModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

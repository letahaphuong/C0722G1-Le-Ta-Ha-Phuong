import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentCreateSanPhamComponent } from './component-create-san-pham.component';

describe('ComponentCreateSanPhamComponent', () => {
  let component: ComponentCreateSanPhamComponent;
  let fixture: ComponentFixture<ComponentCreateSanPhamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponentCreateSanPhamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentCreateSanPhamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

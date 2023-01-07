import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentDeleteComponent } from './component-delete.component';

describe('ComponentDeleteComponent', () => {
  let component: ComponentDeleteComponent;
  let fixture: ComponentFixture<ComponentDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponentDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

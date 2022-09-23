import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Listing } from 'src/app/models/listing';
import { ListingService } from 'src/app/services/listing.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  Id!: number;
  listings: Listing[] = [];

  constructor(private listingService: ListingService, private router: Router) { }

  ngOnInit(): void {
    this.getListing();
  }

  private getListing(){
    this.listingService.getListingList().subscribe(data =>{
      this.listings = data;
    });
  }

  deleteListing (id: number){
    this.listingService.deleteListing(id).subscribe(data =>{
   console.log(data);
      this.getListing();
    })
  }

  updateListing(id: number){
    this.router.navigate(['listings', id]);
  }

  listingDetails(id:number){
    this.router.navigate(['listingdetails', id]);
  }

}

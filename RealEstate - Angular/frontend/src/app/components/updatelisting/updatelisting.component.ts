import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Listing } from 'src/app/models/listing';
import { ListingService } from 'src/app/services/listing.service';

@Component({
  selector: 'app-updatelisting',
  templateUrl: './updatelisting.component.html',
  styleUrls: ['./updatelisting.component.css']
})
export class UpdatelistingComponent implements OnInit {

  Id!: number;
  listing: Listing = new Listing();
  constructor(private listingService: ListingService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.Id = this.route.snapshot.params['id'];
    this.listingService.getListingById(this.Id).subscribe(data =>{
      this.listing = data;
    },error => console.log(error));
  }

  onSubmit(){
    this.listingService.updateListing(this.Id, this.listing).subscribe(data =>{
      this.goToListingList();
    },
       error => console.log(error));
       

  }

  goToListingList(){
    this.router.navigate(['/listings']);

  }

}

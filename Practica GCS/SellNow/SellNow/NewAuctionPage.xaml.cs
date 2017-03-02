using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace SellNow
{
	public partial class NewAuctionPage : ContentPage
	{
		public ListView ListView { get { return listView; } }
		public NewAuctionPage()
		{
			InitializeComponent();
			List<Category> listCategory = new List<Category>();

			listCategory.Add(new Category
			{
				Title = "Deportes"
			});

			listCategory.Add(new Category
			{
				Title = "Hogar"
			});
			listCategory.Add(new Category
			{
				Title = "Automóvil"
			});
			listView.ItemsSource = listCategory;
		}
		async void OnNewButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new MainPage());
		}
	}
}

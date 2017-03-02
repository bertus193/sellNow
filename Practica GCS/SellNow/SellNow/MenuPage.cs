using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace SellNow
{
	public partial class MenuPage : ContentPage
	{
		public ListView ListView { get { return listView; } }

		public MenuPage()
		{
			InitializeComponent();

			var masterPageItems = new List<SellNowPageItem>();

			masterPageItems.Add(new SellNowPageItem
			{
				Title = "Inicio",
				IconSource = "home.png",
				TargetType = typeof(MainPage)
			});

			masterPageItems.Add(new SellNowPageItem
			{
				Title = "Mi Perfil",
				IconSource = "profile.png",
				TargetType = typeof(ProfilePage)
			});
			masterPageItems.Add(new SellNowPageItem
			{
				Title = "Nueva Subasta",
				IconSource = "newauction.png",
				TargetType = typeof(NewAuctionPage)
			});
			masterPageItems.Add(new SellNowPageItem
			{
				Title = "Login",
				IconSource = "login.png",
				TargetType = typeof(LoginPage)
			});

			listView.ItemsSource = masterPageItems;
		}
	}
}
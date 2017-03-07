using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace SellNow
{
	public partial class CategoriesPage : ContentPage
	{
		public ListView ListView { get { return listView; } }
		public CategoriesPage()
		{
			InitializeComponent();
			List<Category> listCategory = new List<Category>();

			listCategory.Add(new Category
			{
				Title = "Deportes",
				TargetType = typeof(SellNowPage)
			});

			listCategory.Add(new Category
			{
				Title = "Hogar",
				TargetType = typeof(SellNowPage)
			});
			listCategory.Add(new Category
			{
				Title = "Automóvil",
				TargetType = typeof(SellNowPage)
			});
			listView.ItemsSource = listCategory;
		}
	}
}
